package ma.gestiongr.entities;

import java.util.Objects;

public class Equipements {

	private Long id;
	private String Port;
	private String Site;
	private String Code_Equipement;
	private String Nom_Equipement;
	private String Code_Famille;
	private String Nom_Famille;
	private String compteur;
	private String Disponibilite;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPort() {
		return Port;
	}
	public void setPort(String port) {
		Port = port;
	}
	public String getSite() {
		return Site;
	}
	public void setSite(String site) {
		Site = site;
	}
	public String getCode_Equipement() {
		return Code_Equipement;
	}
	public void setCode_Equipement(String code_Equipement) {
		Code_Equipement = code_Equipement;
	}
	public String getNom_Equipement() {
		return Nom_Equipement;
	}
	public void setNom_Equipement(String nom_Equipement) {
		Nom_Equipement = nom_Equipement;
	}
	public String getCode_Famille() {
		return Code_Famille;
	}
	public void setCode_Famille(String code_Famille) {
		Code_Famille = code_Famille;
	}
	public String getNom_Famille() {
		return Nom_Famille;
	}
	public void setNom_Famille(String nom_Famille) {
		Nom_Famille = nom_Famille;
	}
	public String getCompteur() {
		return compteur;
	}
	public void setCompteur(String compteur) {
		this.compteur = compteur;
	}
	public String getDisponibilite() {
		return Disponibilite;
	}
	public void setDisponibilité(String disponibilite) {
		Disponibilite = disponibilite;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Code_Equipement, Code_Famille, Disponibilite, Nom_Equipement, Nom_Famille, Port, Site,
				compteur, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipements other = (Equipements) obj;
		return Objects.equals(Code_Equipement, other.Code_Equipement)
				&& Objects.equals(Code_Famille, other.Code_Famille)
				&& Objects.equals(Disponibilite, other.Disponibilite)
				&& Objects.equals(Nom_Equipement, other.Nom_Equipement)
				&& Objects.equals(Nom_Famille, other.Nom_Famille) && Objects.equals(Port, other.Port)
				&& Objects.equals(Site, other.Site) && Objects.equals(compteur, other.compteur)
				&& Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Equipements [id=" + id + ", Port=" + Port + ", Site=" + Site + ", Code_Equipement=" + Code_Equipement
				+ ", Nom_Equipement=" + Nom_Equipement + ", Code_Famille=" + Code_Famille + ", Nom_Famille="
				+ Nom_Famille + ", compteur=" + compteur + ", Disponibilite=" + Disponibilite + "]";
	}
	public Equipements() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
}
