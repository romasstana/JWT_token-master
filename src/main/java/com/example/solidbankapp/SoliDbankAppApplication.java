package com.example.solidbankapp;


import com.example.solidbankapp.ACCOUNT.AccountBasicCLI;
import com.example.solidbankapp.DAO.AccountDAO;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import jakarta.persistence.EntityManager;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@SpringBootApplication
@SecurityScheme(name = "basicauth", scheme = "bearer", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER, bearerFormat = "JWT")
@AutoConfiguration(after = { DataSourceAutoConfiguration.class })
@ConditionalOnClass({ LocalContainerEntityManagerFactoryBean.class, EntityManager.class, SessionImplementor.class })
@EnableConfigurationProperties(JpaProperties.class)

//@EnableJdbcRepositories
//@AllArgsConstructor
public class SoliDbankAppApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(SoliDbankAppApplication.class);
    }
//    @Bean
//    public Docket swaggerConfig(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .paths(PathSelectors.ant("/api/*"))
//                .apis(RequestHandlerSelectors.basePackage("io.ramazan"))
//                .build();
//    }
    @Override
    public void run(String... arg0) throws Exception {
        boolean running = true;
        String clientID = "1";

        MyCLI myCLI = context.getBean(MyCLI.class);
        AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
        TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
        TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);
        AccountDAO accountDAO = context.getBean(AccountDAO.class);

        String helpMessage = "1 - show accounts\n2 - create account\n3 - deposit\n4 - withdraw\n5 - transfer\n6 - this message\n7 - exit\n";
        System.out.printf("Welcome to CLI bank service\n");
        System.out.printf("Enter operation number: \n");
        System.out.printf(helpMessage);
        while(running){
            try {
            switch(myCLI.getScanner().nextLine()){

                case "1":
                    //System.out.println(accountDAO.getIds("FIXED"));
                    //accountDAO.findAccountsByClientId(clientID);
                    accountBasicCLI.getAccounts(clientID);
                    break;

                case "2":
                    System.out.print("Choose account type\n [CHECKING, SAVING, FIXED]\n");
                    accountBasicCLI.createAccountRequest(clientID);
                    break;

                case "3":
                    System.out.println("Type account ID");
                    transactionDepositCLI.depositMoney(clientID);
                    break;

                case "4":
                    System.out.println("Type account ID");
                    transactionWithdrawCLI.withdrawMoney(clientID);
                    break;

                case "6":
                    System.out.printf(helpMessage);
                    break;

                case "7":
                    System.out.printf("Application Closed\n");
                    running = false;
                    break;
                default:
                    System.out.println("command not recognized\n");
                }
            }
            catch (Exception e){
                System.out.println("exception!");
                e.printStackTrace();
            }
        }
        myCLI.getScanner().close();

    }
}