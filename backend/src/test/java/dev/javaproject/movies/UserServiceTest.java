@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testRegisterUser() {
        User user = new User("john_doe", "password");
        Mockito.when(userRepository.existsByUsername("john_doe")).thenReturn(false);
        userService.registerUser(user);
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    public void testLoginUser() {
        User user = new User("john_doe", "password");
        Mockito.when(userRepository.findByUsername("john_doe")).thenReturn(user);
        boolean result = userService.loginUser(user);
        Assertions.assertTrue(result);
    }
}
