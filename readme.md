# IUT Informatique R5.A05 - Spring

## Contexte fonctionnel des TP Spring

Les TP successifs ont pour objectif de gérer des articles de blogs, sous la forme d'une API RPC (Remote Procedure Call, qui repose sur le protocole HTTP)

### Fonctionnalités

- L’authentification des utilisateurs souhaitant interagir avec les articles. Cette fonctionnalité devra s’appuyer sur les JSON Web Token (JWT). Un utilisateur est caractérisé, a minima, par un nom d’utilisateur, un mot de passe et un rôle (moderator ou publisher)
- La publication, la consultation, la modification et la suppression des articles de blogs. Un article est caractérisé, a minima, par sa date de publication, son auteur et son contenu
- La possibilité de liker/disliker un article. La solution doit permettre de retrouver quel(s) utilisateur(s) a liké/disliké un article

### Autorisations

Un utilisateur authentifié avec le rôle "moderator" peut :

- consulter n’importe quel article. Un utilisateur moderator doit accéder à l’ensemble des informations décrivant un article : auteur, date de publication, contenu, liste des utilisateurs ayant liké l’article, nombre total de like, liste des utilisateurs ayant disliké l’article, nombre total de dislike
- supprimer n’importe quel article

Un utilisateur authentifié avec le rôle "publisher" peut :

- poster un nouvel article
- consulter ses propres articles
- consulter les articles publiés. Un utilisateur publisher doit accéder aux informations suivantes relatives à un article : auteur, date de publication, contenu, nombre total de like, nombre total de dislike
- modifier les articles dont il est l’auteur
- supprimer les articles dont il est l’auteur
- liker/disliker les articles publiés par les autres utilisateurs

Un utilisateur non authentifié peut :

- consulter les articles existants. Seules les informations suivantes doivent être disponibles : auteur, date de publication, contenu

## TP1 - Se familiariser avec la notion de Framework

**Objectif**

Comprendre le rôle d'un framework et s'en servir pour initialiser un projet en complétant le guide QuickStart de Spring

**Ressources:**

1. Présentation de Spring: https://spring.io/
2. Choisir les bons outils: https://spring.io/tools
3. Un environnement de développement adapté
   - JDK 17: https://bell-sw.com/pages/downloads/#jdk-17-lts
   - MySQL: https://dev.mysql.com/downloads/mysql/
   - Postman: https://www.postman.com/downloads/
4. Un gestionnaire de version: https://gitlab.com
5. Documentation Git: https://git-scm.com/docs

**Livrable attendu** 

Un repo Git, public, contenant au moins les commits suivants :

- tag hello-world: votre projet s'exécute, et retourne un Body contenant "Bonjour le monde !" à l'adresse http://localhost:8080/bonjour

**Indications**

- Configuration Spring Initializer : 
  - Type de projet: Maven
  - Langage: Java
  - Version de Spring Boot: 2.7.17
  - Packaging: Jar
  - Version de java: 17
  - Dépendances à sélectionner lors de l'initialisation du projet Spring : 
    - Spring Boot DevTools
    - Spring Web
    - Spring Data JPA
    - MySQL Driver
- Ajouter cette ligne dans le fichier @/src/resources/application.properties: `spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration`. Elle permet de ne pas configurer de base de données pour l'instant
- Commande pour télécharger/mettre à jour les dépendances: `mvn clean install -U`, puis recharger le projet dans votre IDE avant de ré-executer le projet

**Erreurs fréquentes**

- Failed to determine a suitable driver class: https://www.baeldung.com/spring-boot-failed-to-configure-data-source
- Attention à la version de Java installé sur votre poste/configurer dans votre IDE

## TP2 - Mettre à profit le framework

**Objectif**
Configurer la base de données, ajouter des controllers, et comprendre comment mettre à profit le framework pour produire de nouvelles fonctionnalités rapidement

**Ressources:**

1. [Spring: Accessing data with Mysql](https://spring.io/guides/gs/accessing-data-mysql/)
2. [Créer des relations entre mes entités en JPA](https://medium.com/huawei-developers/database-relationships-in-spring-data-jpa-8d7181f50f60)
3. Pour aller plus loin concernant RESTful : [Spring: Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

**Livrable attendu**
Un repo Git contenant au moins les commits suivants :

- un tag 'db-ready' pour l'ajout de la connexion à la base de données
- un commit par fonctionnalité ajouté à votre API. Il ne s'agit pas de gérer les authorisations pour le moment. Votre projet doit être et rester fonctionnel à chaque étape.

**Indications**

- Attention à la documentation fournie en ressource. Il ne s'agit pas d'appliquer à la lettre les étapes proposées, mais plutôt de s'en inspirer pour l'appliquer au contexte fonctionnel du TP
- Penser à [créer une base de données](https://dev.mysql.com/doc/refman/8.0/en/creating-database.html) et [ajouter un utilisateur](https://www.digitalocean.com/community/tutorials/how-to-create-a-new-user-and-grant-permissions-in-mysql) exprès pour ce projet.
- Commande pour télécharger/mettre à jour les dépendances: `mvn clean install -U`, puis recharger le projet dans votre IDE avant de ré-executer le projet
- Lisez les logs de lancement de l'application. Ils vous en disent beaucoup sur les configurations détectées/chargées par Spring
- Avant de créer vos tables en SQL, écrivez votre entité java, executez à nouveau votre projet, et jetez à nouveau un oeil à votre BDD

**Erreurs fréquentes**

## TP3 - Sécurité

**Objectif**
Comprendre comment paramétrer un framework, surcharger ses comportements par défaut, et y intégrer nos propres besoins sans tout ré-inventer.

**Ressources:**

1. [Dépendance à ajouter](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security)
2. [Documentation du package de sécurité Spring](https://docs.spring.io/spring-security/reference/servlet/authentication/architecture.html)
3. [Gérer une liste d'utilisateurs, et vérifier leur login/mot de passe](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/index.html)
4. [Method Security: gérer des autorisations par role](https://docs.spring.io/spring-security/reference/servlet/authorization/method-security.html)
5. [Qu'est ce qu'un OncePerRequestFilter](https://www.baeldung.com/spring-onceperrequestfilter)

Pour aller plus loin, fonctionnement et interets de [l'injection de dépendance](https://gayerie.dev/docs/spring/spring/principe_ioc.html)

**Livrable attendu**
Un repo Git contenant au moins les commits suivants :

- tag authentification : vous avez ajouté l'obligation de s'authentifier pour accéder aux différentes fonctionnalités"
- tag autorisations : Vous avez adapté le comportement des différentes fonctionnalités en fonction de l'identité et des roles de l'utilisateur connecté

**Indications**

- Commande pour télécharger/mettre à jour les dépendances: `mvn clean install -U`, puis recharger le projet dans votre IDE avant de ré-executer le projet
- Ce troisième TP compte 90% de lecture et 10% de rédaction de code. Prenez le temps de lire la documentation de manière exhaustive. Mieux vous comprendrez un framework, moins vous aurez de code à écrire.
- Voici le code nécessaire pour produire le **J**son**W**eb**T**oken:

```
@Component
public class TokenGenerator {

    @Value("${r5a05.app.jwtSecret}")
    private String jwtSecret;

    @Value("${r5a05.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(Authentication authentication) {

        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();

        Date tokenCreationDate = new Date();
        Date tokenExpirationDate = new Date(tokenCreationDate.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(tokenCreationDate)
                .setExpiration(tokenExpirationDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}
```

- le code pour valider/décrypter le token lors des requêtes suivantes

```
@Component
public class TokenValidator {
    private static final Logger logger = LoggerFactory.getLogger(TokenValidator.class);
    private final String jwtSecret;

    public TokenValidator(@Value("${r5a05.app.jwtSecret}") String _jwtSecret) {
        this.jwtSecret = _jwtSecret;
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }
}
```

- ainsi que la dépendance à ajouter pour utilisater 'Jwts'

```
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt</artifactId>
    <version>0.9.1</version>
</dependency>
```

- Un élément de configuration central, à compléter (les classes 'R5A05' utilisées ci-dessous sont à écrire à partir de la documentation Spring)

```
@Configuration
@EnableWebSecurity
public class R5A05WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Autowired
    UserDetailsServiceR5A05 userDetailsService;

    @Bean
    public OncePerRequestFilterR5A05 authenticationJwtTokenFilter() {
        return new OncePerRequestFilterR5A05();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/login").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(authenticationProvider);
    }
    
    @Bean
    public UserDetailsService userDetailsService(@Autowired UserDetailsServiceR5A05 userDetailsService) {
        return userDetailsService;
    }
}
```

- Une classe représentant un Bearer JWT

```
@Getter
@AllArgsConstructor
public class JwtDTO {
    private final String token;
    private final String type = "Bearer";
    private final String username;
    private final List<String> roles;
}
```

**Erreurs fréquentes**
