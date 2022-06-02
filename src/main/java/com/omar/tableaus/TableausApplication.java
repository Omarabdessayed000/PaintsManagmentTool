package com.omar.tableaus;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.omar.tableaus.entities.Tableau;
import com.omar.tableaus.service.TableauService;

@SpringBootApplication
public class TableausApplication implements CommandLineRunner {
	
	@Autowired
	TableauService tableauService;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(TableausApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*tableauService.saveTableau(new Tableau ("TestTest",9999.9,"Test Author",new Date()));
		tableauService.saveTableau(new Tableau ("Mona Lisa",4800.5,"Leonardo da Vinci",new Date()));
		tableauService.saveTableau(new Tableau ("The Starry Night",7400.0,"Vincent van Gogh",new Date()));
		tableauService.saveTableau(new Tableau ("The Birth of Venus",3400.4,"Sandro Botticelli",new Date()));
		tableauService.saveTableau(new Tableau ("The Hay Wain",9040.4,"The Last Supper",new Date()));
		tableauService.saveTableau(new Tableau ("The Night Watch",5400.4,"Rembrandt",new Date()));
		tableauService.saveTableau(new Tableau ("Las Meninas",6200.0,"Diego Velázquez",new Date()));
		tableauService.saveTableau(new Tableau ("American Gothic",7000.5,"Grant Wood",new Date()));
		tableauService.saveTableau(new Tableau ("Liberty Leading the People",7800.5,"Eugène Delacroix",new Date()));
		tableauService.saveTableau(new Tableau ("Guernica",3400.0,"Pablo Picasso",new Date()));
		tableauService.saveTableau(new Tableau ("Bal du moulin",9200.4,"Pierre-Auguste Renoir",new Date()));
		tableauService.saveTableau(new Tableau ("Café Terrace at Night",7450.0,"Vincent van Gogh",new Date()));*/
		
		repositoryRestConfiguration.exposeIdsFor(Tableau.class);
	}

}
