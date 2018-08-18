package com.sc.test.seat;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SeatApplication {
	private static Logger logger = LoggerFactory.getLogger(SeatApplication.class);

	@Autowired
	StrategyContext context;

	public static void main(String[] args) {

		SpringApplication.run(SeatApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	
		return args -> {
			String input = null;
			
			if (args.length != 1) {
				System.out.println("Plese provide input like 'UD' ");
				logger.error("Plese provide input like 'UD' ");
				System.exit(-1);
			}

			logger.info("args[0] is {}", args[0]);

			input = args[0];
			if (input.length() < 2 || input.length() > 1000) {
				System.out.println("Length for the input should be 2~1000");
				logger.error("Length for the input should be 2~1000");
				System.exit(-1);
			}

			String regex = "^[U|D]+$";
			Pattern regular = Pattern.compile(regex);
			Matcher matcher = regular.matcher(input);
			if (!matcher.matches()) {
				System.out.println("The input can only be combination of 'U' or 'D'");
				logger.error("The input can only be combination of 'U' or 'D'");
				System.exit(-1);
			}

			//output for console
			Integer[] aryResult = context.seeAllStrategies(input);
			System.out.println("\n\n------------------------");
			for (int i = 0; i < 3; i++) {
				System.out.println(aryResult[i]);
			}
			System.out.println("------------------------\n\n");


			//output of log
			logger.info("");
			logger.info("");
			logger.info("------------------------");
			for (int i = 0; i < 3; i++) {
				logger.info(aryResult[i].toString());
			}
			logger.info("------------------------");
			logger.info("");
			logger.info("");
			
			
		};

	}

}
