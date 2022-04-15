package net.developia.boot_article.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import net.developia.boot_article.dto.ArticleDTO;
import net.developia.boot_article.service.ArticleService;

@Log4j2
@Controller
@RequestMapping("article/{pg}")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;

	@Value("${pageSize}")
	private long pageSize = 10;
	
	@Value("${blockSize}")
	private long blockSize = 10;
	
	@GetMapping("insert")
	public String insertArticle() {
		return "article/insert";
	}	
	
	@PostMapping("insert")
	public String insertBoard(@ModelAttribute ArticleDTO articleDTO,
		Model model) {
		
		log.info(articleDTO.toString());
		try {
			articleService.insertArticle(articleDTO);
			return "redirect:../1/";
		} catch (Exception e) {
			model.addAttribute("msg", "입력 에러");
			model.addAttribute("url", "javascript:history.back();");
			return "result";
		}
	}
	
	@GetMapping("/")
	public String list(@PathVariable long pg, 
		Model model) throws Exception {
		
		try {
			long recordCount = articleService.getArticleCount();
			long pageCount = recordCount / pageSize;
			if (recordCount % pageSize != 0) pageCount++;
			
			List<ArticleDTO> list = articleService.getArticleListPage(pg);

			long startPage = (pg - 1)/blockSize*blockSize+1;
			long endPage   = startPage + blockSize - 1;
			if (endPage > pageCount) endPage = pageCount;
			
			model.addAttribute("list", list);
			model.addAttribute("pageCount", pageCount);
			model.addAttribute("pg", pg);
			model.addAttribute("startPage", startPage);
			model.addAttribute("endPage", endPage);
			model.addAttribute("recordCount", recordCount);
			model.addAttribute("pageSize", pageSize);
			return "article/list";
		} catch (Exception e) {
			model.addAttribute("msg", "list 출력 에러");
			model.addAttribute("url", "index");
			return "result";
		}
	}
	
}
