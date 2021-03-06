package com.example.login;

    @Controller
    public class UserController {
        @Autowired
        private UserService userService;
        @Autowired
        private SecurityService securityService;
        @Autowired
        private UserValidator userValidator;
        @RequestMapping(value = "/registration", method = RequestMethod.GET)
        public String registration(Model model) {
            model.addAttribute("userForm", new User());
            return "registration";
        }
        @RequestMapping(value = "/registration", method = RequestMethod.POST)
        public String registration(@ModelAttribute("userForm") User userForm,
                                   BindingResult bindingResult, Model model) {
            userValidator.validate(userForm, bindingResult);
            if (bindingResult.hasErrors()) {
                return "registration";
            }
            userService.save(userForm);
            securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
            return "redirect:/welcome";
        }
        @RequestMapping(value = "/login", method = RequestMethod.GET)
        public String login(Model model, String error, String logout) {
            if (error != null)
                model.addAttribute("error", "Your username and password is invalid.");
            if (logout != null)
                model.addAttribute("message", "You have been logged out successfully.");
            return "login";
        }
        @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
        public String welcome(Model model) {
            return "welcome";
        }
    }
}
