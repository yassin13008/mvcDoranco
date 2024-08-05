Bonjour à tous et bienvenu sur ce projet 

Pour que vous puissiez bosser en toute tranquilité, prenez suis de ce read.me


J'ai crée les branches pour chacun des tickets (tâches qui nous a été assigné)
Je vous remez ici le lien Jira pour que vous puissiez retrouver chacune des tâches assignés

https://mounir-yahyaoui-doranco.atlassian.net/jira/software/projects/KAN/boards/1

Pour que vous puissiez travailler en toute sérénité, Je vous ai crée des branches pour les tâches principales dispo sur Jira
Comme chaque tâche a été dégoupiller en plusieur tâches, je vous laisse le soin de créer ces branches la mais certaines normes de monenclature doivent être respecter (le fait de mettre votre nom + la fonctionnalité sur laquel vous travaillez)

Ainsi votre travail ne pertubera pas celui des autres. Lorsque vous estimez que votre travail est terminé, vous feras une demande de pull request votre branche au tech lead
Ainsi le LeadTech prendra connaissance de votre travail, et vous fera signe si votre code est correct

Votre code source provient de master donc chacune de vos branche est inspiré de celle-ci et pas d'une autre

Voici comment vous créer une branche à partir de master 

1) Vous prenez d'une part le clone du projet : https://github.com/yassin13008/mvcDoranco.git
2) Vous verifier bien que vous vous trouvez sur la branche master (git status est la ligne de commande qui vous permet de faire cela)
3) Vous créer votre branche a partir de master avec la commande suivante : git checkout -b feature/new-feature_votrenom
4) Quand vous avez terminé votre travail, vous pousser vos modifs sur votre branche : git push origin feature/new-feature_notrenom
5) Vous demandez une pull request ( si cela est validé, je mergerai votre branche sur master )
