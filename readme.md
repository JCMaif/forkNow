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