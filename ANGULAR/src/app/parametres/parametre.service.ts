import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Equipements } from '../model/Equipements';

@Injectable({
  providedIn: 'root'
})
export class ParametresService {

  constructor(private http: HttpClient) { }
 
  //webServices Engin
   listeEngins(){
    return this.http.get(environment.url_gestion_engin_db+'/engins/');
    }

    deleteEngin(id){
      return this.http.delete(environment.url_gestion_engin_db+`/engins/${id}`);
    }
    PutEngin(listeEngins)
    {
     return this.http.put(environment.url_gestion_engin_db+`/engins/${listeEngins.codeEngin}`,listeEngins);
    }
    addEngins(listEngins){

      return this.http.post(environment.url_gestion_engin_db+'/engin/addEngins',listEngins );
    }
   //webServices Critere
   deleteCritere(id){
    return this.http.delete(environment.url_gestion_engin_db+`/criteres/${id}`);
  }
 
  PutCritere(listcritere)
  {
   return this.http.put(environment.url_gestion_engin_db+`/criteres/${listcritere.idCritere}`,listcritere);
  }
  listeCritere(){

    return this.http.get(environment.url_gestion_engin_db+'/criteres');
  }
  addcritere(NomCritere){
    return this.http.post(environment.url_gestion_engin_db+'/criteres',NomCritere );
  }
  /////// WebServices Familles
  deleteFamil(id){
    return this.http.delete(environment.url_gestion_engin_db+`/famille/${id}`);
  }
 
  PutFamil(listeFamil)
  {
   return this.http.put(environment.url_gestion_engin_db+`/famille/${listeFamil.idFamille}`,listeFamil);
  }
  listeFamil(){
    
    return this.http.get(environment.url_gestion_engin_db+'/famille/' );
  }
  
  addFamil(listeFamil){
    return this.http.post(environment.url_gestion_engin_db+'/famille/',listeFamil );
  }



 
  //web services Postes
  listePosts(){

    return this.http.get(environment.url_gestion_engin_db+'/posts/get' );
  }

  addPost(Listeposts){
    return this.http.post(environment.url_gestion_engin_db+'/posts/add',Listeposts);
  
   }

   deletePost(id){
    return this.http.delete(environment.url_gestion_engin_db+`/posts/${id}`);
  }

  PutPost(Listeposts){
    return this.http.put(environment.url_gestion_engin_db+`/posts/${Listeposts.id}`,Listeposts);
    
  }
   //Xebservices Entites
 
  addEntite(listeEntites){
   return this.http.post(environment.url_gestion_engin_db+'/entites/',listeEntites );
  }
  deleteEntite(id){
    return this.http.delete(environment.url_gestion_engin_db+`/entites/${id}`);
  }

  
  listeEntite(){
    return this.http.get(environment.url_gestion_engin_db+'/entites/' );
  }

  
  PutEntite(listeEntites){
    return this.http.put(environment.url_gestion_engin_db+`/entites/${listeEntites.id}`,listeEntites);
 }

   //web services Utilisateur
   addUser(listeUser){
    return this.http.post(environment.url_gestion_engin_db+'/users/',listeUser );
   }
   listeUser(){
   return this.http.get(environment.url_gestion_engin_db+'/user' );
  }

  deleteUser(id){
    return this.http.delete(environment.url_gestion_engin_db+`/users/${id}`);
  }
  PutUser(listeUser){
    return this.http.post(environment.url_gestion_engin_db+'/user/',listeUser);
    
  }
}
