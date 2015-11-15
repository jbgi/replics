# Introduction #

Replics's Embedded P2P Loosely Interconnected Census System. Aiming at providing a flexible, tolerant.

# Contexte #

Le projet REPLICS s’intègre dans le cadre dans un grand projet consistant à mettre en place une solution informatique de recensement de population dans des pays post-conflit.
Dans notre cas, la solution sera dédiée au Soudan, elle sera développée à la demande de l’ONU qui a aussi pour mission de délivrer une assistance électorale dans ces pays.
Le produit fini devra inclure les fonctionnalités suivantes :
Enregistrer une personne dans une base de données locale via un formulaire classique.
Prendre l’empreinte digitale, la stocker et l’associer à la personne dans la base de données.
Prendre la photographie et l’associer à la personne dans la base de données.
Vérifier que la personne n’est pas redondante.
Délivrer une carte d’identité.
Ces aspects présentent des failles notamment :
La sécurité : En effet si un ordinateur se fait voler ou tombe en panne nous aurons une perte totale de toutes les données y sont enregistrées.
La redondance : Comme les bases de données sont indépendantes, des personnes peuvent avoir plusieurs cartes d’identité en s’enregistrant auprès de différents recenseurs.

C’est dans ce cadre que le projet REPLICS répond à la problématique en mettant en place un système de communication entre les différents ordinateurs ainsi qu’un système de sauvegarde de données dans un endroit géopolitiquement sûr.
Concrètement, notre système devra être en mesure de propager les informations enregistrées auprès d’un recenseur sur son ordinateur local vers tous les ordinateurs des autres recenseurs dans un rayon d’une distance à définir (a priori supérieur 10km). Cette réplication de données devra être fiable et répondre à plusieurs critères de sécurité et confidentialité.


# Objectif #

La partie REPLICS est indépendante des autres composantes de la solution à part pour la base de données. En effet, comme cette dernière sera partagée entre toutes les applications, il était indispensable de la concevoir en concertation avec les autres équipes.
Le reste du projet étant indépendant, nous avons la liberté de choix des technologies et méthodes à utiliser.
Le système devra être capable de propager des données d’un ordinateur (dispositif mobile) à un autre avec les deux contraintes principales de sécurité et confidentialité des données. Le récepteur devra aussi propager ses données ainsi que les données reçu si elles n’ont pas encore atteint un serveur fixe.

# Fonctionnalités du système #

Nous présentons ici les principales fonctionnalités de REPLICS : le transfert de données d’un nœud du réseau à un autre et la sauvegarde de ces données chez le récepteur, puis le recouvrement des données lors de la restauration.


## Transmission des données ##

La première nécessité pour notre système est le transfert des données d’un nœud à un autre, pour cela nous comptons utiliser des communications hertziennes pour sa fiabilité relative à son coût très bas par rapport à d’autres communications du genre GSM. Ainsi, plusieurs contraintes sont à prendre en compte :

Le coût de la communication : qui correspond à la quantité d’énergie requise et au nombre de sauts nécessaires pour atteindre un noeud dans le cas d’un réseau ad hoc ainsi que le matériel qui sera mis en place pour assurer la fonctionnement et la fiabilité de cette transmission.

la densité de l’environnement dans lequel évolue le dispositif mobile, c’est-à-dire le nombre de noeuds avec lesquels peut communiquer un noeud influence la probabilité de trouver de l’espace de stockage à proximité

la volatilité des connexions (déconnexions fréquentes et parfois permanentes dans le cas d’un réseau ad hoc, ou au contraire connexions stables et quasi permanentes entre deux noeuds communiquant directement via une infrastructure) influence la granularité des fragments à sauvegarder.

Pour répondre au mieux à ces critères, nous trouvons que le modèle le plus adapté serait un réseau peer-to-peer en propageant les données sur une zone relativement grande (un rayon de plus de 15km). Les données transmises seront bien entendu cryptées. Nous ne sommes pas encore penchés sur cette question.

## Recouvrement des données ##

Les données qui seront stockées sur les dispositifs mobiles arrivent cryptées. Ainsi, il faut un algorithme inverse pour les décrypter, défragmenter et stocker dans la base de données. Le récepteur joue après le rôle du transmetteur jusqu’à l’arrivé à un serveur fixe qui se chargera d’ouvrir une connexion très sécurisé de type GSM vers un serveur de backup très probablement de dehors du pays.