@Service
public class NewsArticleService {
    @Autowired
    private NewsArticleRepository repository;

    public List<NewsArticle> getLatestArticles() {
        return repository.findTop10ByOrderByIdDesc();
    }

    public NewsArticle getArticleById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
    }

    public NewsArticle saveArticle(NewsArticle article) {
        return repository.save(article);
    }
}
