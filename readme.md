# Fork Now

## Démarrer le projet

### Création de la base de données

Créer une base de données PostgreSql :
- caractéristiques : jdbc:postgresql://localhost:5432/fork_now?currentSchema=public
- username: postgres  
- password: postgres

### Démarrage du projet :

#### Build
```batch
$ ./gradlew build
```

#### Run
```batch
$ ./gradlew bootRun
```

## Projet Fork Now

### Objectifs :
- Utiliser Spring boot security (3.3.1) pour gérer l'authentification, les autorisations et la protection
- Utiliser Thymeleaf pour les templates générés par le serveur

### Profils de test du site :
- Profil utilisateur : 
  - username : Customer
  - password : customer


- Profil Administrateur :
  - username : Admin
  - password : admin


- Profil Propriétaire de restaurant :
  - username : Patron
  - password : patron


- Profil Employé de restaurant :
  - username : Employe
  - password : employe

## TODO

- [x] Initialisation de la base au démarrage
  - [x] Utilisateur avec rôles différents
  - [x] Type de cuisine
  - [x] Restaurant
  - [x] Affectation de type(s) de cuisine à un restaurant
  - [x] Ajout ou suppression d'un restaurant pour un utilisateur
- [x] Externalisation du css
- [x] Utilisation des fragments thymeleaf
- [x] Affichage homepage
- [x] Login et redirection
- [x] Logout et redirection
- [x] Affichage de tous les restaurants de la base
- [x] Boutons conditionnels pour ajouter le restaurant sélectionné à l'utilisateur
- [x] Affichage des restaurants d'un utilisateur
- [x] Bouton pour supprimer un restaurant de la liste utilisateur
- [x] Boutons ou liens affichés selon le rôle (SHOP_OWNER, SHOP_EMPLOYEE)
  - [x] Affichage conditionnel des boutons
  - [ ] Fonctionnalité implémentée (Edit, Delete)
- [x] Signup avec enregistrement dans la base
- [x] Tous les types de cuisine selon le rôle ("/cuisines-list")
- [x] Création d'un restaurant si utilisateur = propriétaire
- [ ] Suppression d'un restaurant si utilisateur = propriétaire
- [ ] Modification d'un restaurant par le propriétaire ou un employé
- [ ] Gestion des utilisateurs par Admin
- [ ] Gestion des restaurants par Admin
- [ ] Gestion des types de cuisine par Admin (partiellement fait)
