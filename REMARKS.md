# Quelques remarques sur l'exercice : 

## Hypothèses prises: 

* Un joueur peut être présent dans l'équipe pour plusieurs années
* Un joueur peut être capitaine dans l'équipe de l'année N mais non capitaine pour une autre année
* Si un joueur est présent dans l'équipe pour plusieurs années, alors ses informations (numéro, nom, prénom, poste) sont les mêmes (au rôle de capitaine près) peu importe l'année.  
Sinon il faudrait modifier le modèle pour qu'un joueur puisse avoir un numéro différent suivant l'année par exemple.
* Pas de contrôle pour s'assurer qu'un joueur (nom/prenom/poste/numero) est unique

## Remarques :

1. le PUT pour mettre à jour un joueur en tant que capitaine indique (readme) :   
``Un PUT pour mettre à jour le capitaine de l'equipe pour une année définie``  
Or dans le endpoint proposé dans le readme ou dans le postman, il n'y a pas de notion d'année, cela supposerait donc de mettre à jour un joueur en tant que capitaine sans tenir compte de l'année ?  
j'ai donc fait le choix de pouvoir mettre à jour un joueur (y compris le rôle de capitaine) au travers du endpoint suivant:  
``/api/teams/{{year}/players/{{number}}``  
avec en body le contenu du joueur (afin de respecter les préconisations REST) et en supposant (pour l'exercice) 
que si le endpoint est appelé alors c'est pour que le joueur soit capitaine.  
Afin de respecter les preconisations REST le joueur est crée s'il n'existe pas déjà (PUT).  
Pas de vérification que le joueur est déjà présent dans l'année cible.  
On aurait aussi pu utiliser un PATCH vu que le but est de ne faire qu'une mise à jour partielle

3. Le contenu de postman ne semble pas totalement cohérent avec le readme  
par ex : http://localhost:8080/api/player dans le readme pour ajouter un joueur vs http://localhost:8080/api/team/2021 dans postman

4. Il serait préférable d'utiliser des mots au pluriel pour les noms de ressources  
``http://localhost:8080/api/team/{{year}} => http://localhost:8080/api/teams/{{year}}``

5. Il faudrait revoir le endpoint pour ajouter un joueur pour respecter les règles de design
http://localhost:8080/api/teams/{{year}} => http://localhost:8080/api/teams/{{year}}/players

J'ai modifié les endpoints et ai donc exporté la collection postman. 

6. url pour open api : `http://localhost:8080/api/swagger-ui/index.html#/`

