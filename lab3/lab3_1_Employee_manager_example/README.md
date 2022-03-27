a)Example1:
    assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());
    Example2:
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

b) Example:
    @MockBean
    private EmployeeService service;
    Employee alex = new Employee("alex", "alex@deti.com");
    when( service.save(Mockito.any()) ).thenReturn( alex);

c)Use case:
As we write a test that doesn't need any dependencies from the Spring Boot container, the @Mock is the way to follow : it is fast and favors the isolation of the tested component.
If our test needs to rely on the Spring Boot container and we want also to add or mock one of the container beans : @MockBean from Spring Boot is the way.

References:
https://stackoverflow.com/questions/44200720/difference-between-mock-mockbean-and-mockito-mock
https://rieckpil.de/difference-between-mock-and-mockbean-spring-boot-applications/

d)

