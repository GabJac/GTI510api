package business.manager;

import model.Article;

import java.util.HashMap;
import java.util.Map;

public class ArticleUtils {

    public static Map<Integer, Article> articles = new HashMap();

    static {
        Article a1 = new Article();
        a1.setId(1);
        a1.setAuthor("Association des étudiants de l’ÉTS");
        a1.setTitle("Le but de l’AÉÉTS (votre association étudiante)");
        a1.setText("Favoriser l’esprit de coopération entre les étudiants et organismes étudiants tant à l’intérieur qu’à l’extérieur de l’ÉTS.\n" +
                "Promouvoir, organiser, superviser, administrer la défense des droits intérêts de tous les étudiants et étudiantes de l’ÉTS, et ce dans tous les départements, tant au premier cycle que pour les cycles supérieurs, du point de vue moral, social, intellectuel, économique et pédagogique.\n" +
                "L’Association est laïque et sa formation découle d’un désir de représentation commune en vue de promouvoir et de défendre les droits et intérêts des étudiantes et étudiants de l’École.\n" +
                "L’Association a pour principaux objectifs :\n" +
                "D’exprimer et de défendre les droits et les intérêts de ses membres, notamment en matière pédagogique, culturelle, économique, politique, sociale et d’administration universitaire\n" +
                "D’agir en tant qu’intermédiaire entre ses membres et l’École\n" +
                "D’organiser des activités sociales, culturelles et sportives qui soient de nature à profiter à l’ensemble de ses membres et à accentuer l’esprit d’appartenance à l’Association\n" +
                "D’offrir des services avantageux à ses membres, notamment grâce à ses entreprises\n" +
                "De diffuser de l’information à ses membres à l’aide de ses différents médias\n" +
                "D’assurer une présence constante pour ses membres\n" +
                "En gros c’est un ponzi schème basé sur l'indifférence générale de la communauté étudiante\n");



        Article a2 = new Article();
        a2.setId(2);
        a2.setAuthor("Le VP académique de l’AÉÉTS");
        a2.setTitle("Contester une note");
        a2.setText("Pour contester une note reçue dans le cadre d’un cours il y a plusieurs étapes à suivre pour réussir à obtenir un résultat convaincant.\n" +
                "En premier lieu, il faut du courage. Sinon rien n’est possible.\n" +
                "En deuxième lieu, il faut un plan concret et facile à comprendre pour les différentes formes de fonctionnaire se trouvant à l’ÉTS.\n" +
                "En troisième lieu, c’est un mystère.\n" +
                "Et finalement, félicitation votre note à changé.\n");



        Article a3 = new Article();
        a3.setId(3);
        a3.setAuthor("Un meuble du Resto-Pub");
        a3.setTitle("Le but de l’AÉÉTS (votre association étudiante)");
        a3.setText("Seul certain initié connaisse le fait qu’il existe un menu secret au Resto-Pub le 100 génies.\n" +
                "Maintenant que vous lisez cet article, vous êtes initié. Donc, voici une liste de certains items que vous pouvez commander au Resto-Pub.\n" +
                "Une poutine princesse extra poulet général tao.\n" +
                "Une assiette de bacon.\n" +
                "Un S.O.N.I.A. (c’est une consommation aux canneberges)\n" +
                "Tu peux demander un tester de bière avant de faire ton choix.\n");



        Article a4 = new Article();
        a4.setId(4);
        a4.setAuthor("Ramoloss");
        a4.setTitle("Ne pas avoir l’air d’un paresseux");
        a4.setText("Un des meilleurs secrets qu’il existe pour ne pas avoir l’air d’un paresseux à l’ÉTS pour prendre l’ascenseur pour aller au premier étage du pavillon A ou B est de ne pas prendre l’ascenseur au rez-de-chaussée, mais bien de le prendre à partir du sous-sol lors que vous passé par le passage souterrain entre les deux pavillons.");



        Article a5 = new Article();
        a5.setId(5);
        a5.setAuthor("Mathieu");
        a5.setTitle("Rabais étudiant");
        a5.setText("L’AÉÉTS offre une app nommée AÉÉTS FOOD qui permet d’obtenir des rabais dans les restaurants du secteur Griffintown.\n" +
                "Jusqu’à 75 % de rabais par repas dans les restaurants autour du campus de l’ÉTS!\n" +
                "Fonctionnement:\n" +
                "Choisis la promotion qui te convient sur l’application,\n" +
                "Présente-toi dans le restaurant de l’offre,\n" +
                "Présente le coupon sur ton téléphone et voilà!\n" +
                "Télécharge l’app ici :\n" +
                "Android               iOS\n" +
                "Bon appétit!\n");

        articles.put(1, a1);
        articles.put(2, a2);
        articles.put(3, a3);
        articles.put(4, a4);
        articles.put(5, a5);
    }
}
