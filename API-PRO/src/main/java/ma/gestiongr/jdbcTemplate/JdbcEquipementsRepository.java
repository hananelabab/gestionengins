package ma.gestiongr.jdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ma.gestiongr.dao.EquipementsRepository;
import ma.gestiongr.entities.Equipements;

@Repository
public class JdbcEquipementsRepository implements EquipementsRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Equipements> findAll() {
		return this.jdbcTemplate.query(
				"select 'DEPC' as 'Port',case mo.site_key when 'DEL' then 'DTP' when 'DER' then 'DTP' when 'DEL/TC' then 'DTC' when 'DEP/TC' then 'DTC' ELSE mo.site_key END as 'Site',mo.mo_key as 'Code Equipement'"
						+ ",mo.mo_name as 'Nom Equipement',mo.mo_group_key as 'Code Famille',mg.mo_group_name as 'Nom Famille',dlc.reading as 'Derniere lecture compteur Fonctionnement',"
						+ "case  when mo.mo_key in(select mo_key from work_order wo where wo.jobstatus#=6  and (cast(GETDATE() as date) between cast(start_date as date) and cast(end_date as date)))"
						+ "then 'Non Disponible' else 'Disponible' end as 'Disponibilité'"
						+ "from maintenance_object mo left join mo_group mg on mo.mo_group_key=mg.mo_group_key left join Derniere_lecture_compteur dlc on mo.mo_key=dlc.mo_key and dlc.counter_key like '%/F'where mo.site_key in ('DTV','DEL','DER','DEL/TC','DEP/TC')and (mo.mo_key like 'J99%' OR mo.mo_key like 'X01%' OR mo.mo_key like 'R0%' OR mo.mo_key like 'R1%' OR mo.mo_key like 'R2%' OR mo.mo_key like 'R3%' OR mo.mo_key like 'R4%' OR mo.mo_key like 'R5%' OR mo.mo_key like 'R6%' OR mo.mo_key like 'R7%' OR mo.mo_key like 'R8%' OR mo.mo_key like 'R9%' OR mo.mo_key like 'DTV3%' OR mo.mo_key like 'P1%' OR mo.mo_key like 'P2%' OR mo.mo_key like 'P3%' OR mo.mo_key like 'P4%' OR mo.mo_key like 'P5%' OR mo.mo_key like 'P6%' OR mo.mo_key like 'P7%' OR mo.mo_key like 'P8%' OR mo.mo_key like 'P9%' OR mo.mo_key like 'S4%' OR mo.mo_key like 'S5%' OR mo.mo_key like 'S6%' OR mo.mo_key like 'C4%' OR mo.mo_key like 'E0%' OR mo.mo_key like 'E1%' OR mo.mo_key like 'E2%' OR mo.mo_key like 'E3%' OR mo.mo_key like 'E4%' OR mo.mo_key like 'E5%' OR mo.mo_key like 'E6%' OR mo.mo_key like 'E7%' OR mo.mo_key like 'E8%' OR mo.mo_key like 'E9%' OR mo.mo_key like 'K4%' OR mo.mo_key like 'L1%' OR mo.mo_key like 'L2%' OR mo.mo_key like 'L3%' OR mo.mo_key like 'L4%' OR mo.mo_key like 'L5%' OR mo.mo_key like 'L6%' OR mo.mo_key like 'L7%' OR mo.mo_key like 'T0%' OR mo.mo_key like 'T1%' OR mo.mo_key like 'T2%' OR mo.mo_key like 'T3%' OR mo.mo_key like 'T4%' OR mo.mo_key like 'T5%' OR mo.mo_key like 'T6%' OR mo.mo_key like 'T7%' OR mo.mo_key like 'T8%' OR mo.mo_key like 'T9%' OR mo.mo_key like 'A1%' OR mo.mo_key like 'A2%' OR mo.mo_key like 'A3%' OR mo.mo_key like 'A4%' OR mo.mo_key like 'A5%' OR mo.mo_key like 'A6%' OR mo.mo_key like 'A7%' OR mo.mo_key like 'B0%' OR mo.mo_key like 'B1%' OR mo.mo_key like 'B2%' OR mo.mo_key like 'B3%' OR mo.mo_key like 'B4%'OR mo.mo_key like 'B5%' OR mo.mo_key like 'G1%' OR mo.mo_key like 'G2%' OR mo.mo_key like 'G3%' OR mo.mo_key like 'G4%' OR mo.mo_key like 'G5%' OR mo.mo_key like 'G6%' OR mo.mo_key like 'G7%' OR mo.mo_key like 'I1%' OR mo.mo_key like 'I2%' OR mo.mo_key like 'I3%' OR mo.mo_key like 'I4%' OR mo.mo_key like 'I5%' OR mo.mo_key like 'I6%' OR mo.mo_key like 'I7%' OR mo.mo_key like 'I8%' OR mo.mo_key like 'I9%' OR mo.mo_key like 'M4%' OR mo.mo_key like 'M5%' OR mo.mo_key like 'M6%' OR mo.mo_key like 'M7%' OR mo.mo_key like 'M8%' OR mo.mo_key like 'M9%' OR mo.mo_key like 'PR2%' OR mo.mo_key like 'Q1%' OR mo.mo_key like 'Q2%' OR mo.mo_key like 'Q3%' OR mo.mo_key like 'Q4%' OR mo.mo_key like 'Q5%' OR mo.mo_key like 'Q6%' OR mo.mo_key like 'Q7%' OR mo.mo_key like 'Q8%' OR mo.mo_key like 'Q9%' OR mo.mo_key like 'D0%' OR mo.mo_key like 'GB00%' OR mo.mo_key like 'N0%' OR mo.mo_key like 'PE2%' OR mo.mo_key like 'U00%' OR mo.mo_key like 'V00%' )order by mo.site_key,mo.mo_key",

					

						new RowMapper<Equipements>() {
							public Equipements mapRow(ResultSet rs, int rowNum) throws SQLException {
								Equipements actor = new Equipements();
								actor.setPort(rs.getString("Port"));
								actor.setSite(rs.getString("Site"));
								actor.setCode_Equipement(rs.getString("Code Equipement"));
								actor.setNom_Equipement(rs.getString("Nom Equipement"));
								actor.setCode_Famille(rs.getString("Code Famille"));
								actor.setNom_Famille(rs.getString("Nom Famille"));
								actor.setCompteur(rs.getString("Derniere lecture compteur Fonctionnement"));
								actor.setDisponibilité(rs.getString("Disponibilité"));
								return actor;
							}

						});


	}

}
