@Controller
public class NewsArticleController {
    @Autowired
    private NewsArticleService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("articles", service.getLatestArticles());
        return "index";
    }

    @GetMapping("/new")
    public String newArticleForm(Model model) {
        model.addAttribute("article", new NewsArticle());
        return "new";
    }

    @PostMapping("/new")
    public String saveNewArticle(@ModelAttribute NewsArticle article, BindingResult result) {
        if (result.hasErrors()) {
            return "new";
        }
        service.saveArticle(article);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String viewArticleDetails(@PathVariable Long id, Model model) {
        model.addAttribute("article", service.getArticleById(id));
        return "details";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
