package com.emd.gestionBancaire.metier;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import com.emd.gestionBancaire.entities.Agent;
import com.emd.gestionBancaire.entities.Client;
import com.emd.gestionBancaire.entities.Compte;
import com.emd.gestionBancaire.entities.DemandeCompte;
import com.emd.gestionBancaire.entities.Operation;


public interface IGestiBank {
	
	/*Admin*/
	public void creerAgent(String nom, String prenom);
	public void supprimerAgent(Long id_agent);
	public void editerAgent(Long id_agent);
	public void ajouterDemandeCompte(DemandeCompte demande);
	public void affecterDemandeCompte(Long id_demande, Long id_agent);
	
	/*Agent*/
	public void validerDemande(DemandeCompte demande);
	public void creerClient(Long id_demande, Long id_agent);
	public Collection<Client> getListClient(Long id_agent);
	public void getListClientByMC();
	public void editerClient(Long idClient);
	public List<Operation> getListOperationClientsByDate();
	//public void validerDemandeChequier();
	
	/*Client*/
	public Client chercherClient(Long id_client);
	public void Virement (Long idCompteEnvoyeur, Long idCompteReceveur, Double montant);
	public void commanderChequier();
	public void notificationOperation();
	public void validerDemandeChequier();
	public List<Operation> getListOperationByDate();
	public void imprimerOperation();
	
	/*Compte*/
	public Compte ConsulterCompte(Long id_compte);
	public void Retrait(Long idCompte, Double montant);
	public void Depot(Long idCompte, Double montant);	
	public Page<Operation> ListOperation(Long idCompte, int page, int size);
	public List<Compte> ConsulterAllCompte();
	/*Guest*/
	public void consulterDevise(Double montant, String devise, String devAconvertir);
	public DemandeCompte demandeOuvertureCompte();
	
	
	
}
