package test;
import Connexion.Connexion;
import java.sql.*;

public class DropTable {
	  
	  static{
	    Connexion.getCon();

		try {
			String createClient="create table client("
					+"id int primary key auto_increment,"
					+"nom varchar(100),"
					+"prenom varchar(100),"
					+"telephone varchar(100),"
					+"email varchar(100));";
			String createChambre="create table chambre("
					+"id int primary key auto_increment,"
					+"telephone varchar(100),"
					+"categorie_id int,"
					+"constraint fk3 foreign key(categorie_id) references categorie(id) on delete cascade on update cascade );";
			String createCategorie="create table categorie("
					+"id int primary key auto_increment,"
					+"code varchar(100),"
					+"libelle varchar(100));";
			String createReservation="create table reservation("
					+"id int auto_increment,"
					+"client_id int,"
					+"chambre_id int,"
					+"date_debut date,"
					+"date_fin date,"
					+"primary key(id,client_id,chambre_id),"
					+"constraint fk_v foreign key(client_id) references client (id) on delete cascade on update cascade,"
					+"constraint fk_g foreign key(chambre_id) references chambre(id) on delete cascade on update cascade );";
			
			
			Statement statement=Connexion.getCon().createStatement();
			statement.execute("drop table if exists reservation");
			statement.execute("drop table if exists chambre");
			statement.execute("drop table if exists categorie");
			statement.execute("drop table if exists client");
			
			statement.executeUpdate(createClient);
			statement.executeUpdate(createCategorie);
			statement.executeUpdate(createChambre);
			statement.executeUpdate(createReservation);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  

}
}
