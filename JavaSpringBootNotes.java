/*
	- Java Spring Boot Tutorial Notes:
		- Extra things need to go back and learn:
			- Lambda Expressions & method references, checkout Java 8 Lambda Basics:
			- Spring Boot Testing
		- Spring:
			- Application Framework:
			- Programming & configuration model
			- Infrastructure support
			- Promblems:
				- Huge framework
				- Multple setup steps
				- Multiple configuration steps
				- Multiple build & deploy steps
		- Controller:
			- Used to handle certain task:
				- It's basically a java class
				- It's marked with annotations
				- Has info about:
					- What url access triggers it
					- what method to run when accessed
			- Annotation
				- Example:
					- Get Request:
						- 
						- Syntax:
							@RestController
							public class HelloController {
							}
					
			- Means you can have methods in the class which map to url request & map to method executes
				when user makes request to url
				
		- MVC: The View Tier:
			- Spring MVC --> Maps --> Controller:
				- The controller will have:
					- URI
					- HTTP Method
					- Functionality (Java Method)
				- Converts proper response
		- Project REST API:
			- Topics:
				- get /topics = Gets all topics
				- get /topics/id = Get single topic
				- post /topics = Create new topic
				- put /topics/id = Updates the topic
				- delete /topics/id = Deletes the topic
			- Lessons:
			- Courses:
		
		- Creating Business Service:
			- They are singletons, when spring starts up it creates an instance of this service & keeps 
				it in memory register
			- Step: 1 Create it:
				- Annotation:
					@Service
			- Step 2: Get Service in another application:
				- Create private variable:
				- Syntax:
					- private TopicService topicService;
			- Step 3: Inject it:
				- Use @Autowired for the private variable created
				- Syntax:
					- @Autowired
					  private TopicService topicService;
					  
		- Other Ways of Starting Spring Boot App:
			- Spring Initializr:
				- Website:
					- https://start.spring.io/
				- Fill out:
					- Project:
						- Maven or Gradle
					- Language:
						- Java
					- Spring Boot:
						- Pick Latest Stable
					- Project Metadata:
						- Group:
							- groupId (root package name)
						- Artifact:
							- artifactId (name of the project)
						- Name:
							- name (determines the name of your Spring Boot application)
						- Description:
							- description of the project
						- Package Name:
							- Group attribute is used, if not specified (root pacakge of project)
						- Packaging:
							- start.spring.io can generate jar or war projects
							- Jar	
						- Java:
							- 8
					- Add Dependencies:
						- Spring Web:
							- RESTful app using Spring MVC, Apache Tomcat
			- Spring Boot CLI:
				- Documentation:
					https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-cli.html#cli
				- In order to get it to work, need to install it first, mostly used for groovy scripts
		
		- Configuration of Spring Boot Application
			- Documentation:
				- https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html
			- src/main/resources/
				- create a application.properties file
					- this is where you can do configuration for application at
					
		- JPA (Java Persistence API):
			- ORM (Object - Relational Mapping):
				- Allows you to use java objects as representation of a relational database.
				- Use Spring Data JPA, makes it much simplier and easier to use
			- Dependencies will be using to build project:
				- Spring Web
				- Spring Data JPA
				- Apache Derby Database // this pacakge is an imbed sql database only used for now, but idealy use external
				- MySQL Driver
			- Use JBA:
				- Part A:
					Step 1. Tell JBA to use Topic Class for an example as mapping to database:
						- variables will be columns in database and each instance will be rows in database
					Step 2. Use @Entity Annotation:
						- Example:
							@Entity
							public class Topic{
								public String id;
								...
							}
						- JBA will now know to make a table called Topic & variables will be the column
					Step 3. Tell JBA Primary Key
						- Use @Id Annotation
						- Example:
							- @Id
							  public String id;
				- Part B: Use TopicService to run commands
					Step 4. Create new interface TopicRepository:
						- Spring JPA come with common repository called CrudRepository:
							- It contains all methods need for CRUD
						- Only thing we need to do is extend interface to CrudRepository
						- Example:
							- public interface TopicRepository extends CrudRepository<Topic, String>{...}
					Step 5. Use CRUD operations (TopicRepository) to TopicService:
						- Create member variable & @Autowire it:
							- Example:
								@Autowired
							 	public TopicRepository topicRepository
						
							
					
*/
