package com.omar.tableaus.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.omar.tableaus.entities.Style;
import com.omar.tableaus.entities.Tableau;


@RepositoryRestResource(path = "rest")
public interface TableauRepository extends JpaRepository<Tableau, Long> {
	
	List<Tableau> findByNomTableau(String nom);
	List<Tableau> findByNomTableauContains(String nom);
	
	List<Tableau> findByStyleIdS(Long id);
	
	@Query("select p from Tableau p where p.nomTableau like %?1 and p.prixTableau > ?2")
	List<Tableau> findByNomPrix (String nom, Double prix);
	
	@Query("select p from Tableau p where p.style = ?1")
	List<Tableau> findByStyle (Style style);
	
	List<Tableau> findByOrderByNomTableauAsc();
	
	@Query("select p from Tableau p order by p.nomTableau ASC, p.prixTableau DESC")
	List<Tableau> trierTableauNomsPrix ();
	
	
	@Query("select tableau from Tableau tableau where concat(tableau.nomTableau,' ',tableau.prixTableau,' ',tableau.painterTableau,' ',tableau.dateCreation,' ',tableau.style.nomS) like %?1% ")
	public List<Tableau> search(String keyword);
	
	
	
}	
