package itransition.intern.itransitioncollection.controller.item;

import itransition.intern.itransitioncollection.controller.base.AbstractController;
import itransition.intern.itransitioncollection.dtos.item.ItemCreateDto;
import itransition.intern.itransitioncollection.dtos.item.ItemUpdateDto;
import itransition.intern.itransitioncollection.service.item.ItemService;
import itransition.intern.itransitioncollection.service.search.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/item")

public class ItemController extends AbstractController<ItemService> {

    private final SearchService searchService;

    public ItemController(ItemService service,
                          SearchService searchService) {
        super(service);
        this.searchService = searchService;
    }

    @GetMapping({"/create"})
    public String createPage() {
        return "item/create";
    }

    @PostMapping({"/create"})
    public String create(@ModelAttribute ItemCreateDto dto) {
        service.create(dto);
        return "redirect:item/list";
    }

    @GetMapping({"/detail/{id}", "/get/{id}"})
    public String get(@PathVariable Long id, Model model) {
        model.addAttribute("item", service.get(id));
        return "item/detail";
    }

    @GetMapping({"/list/{collectionId}", "/getAll/{collectionId}"})
    public String getAll(@PathVariable Long collectionId, Model model) {
        model.addAttribute("item", service.getAll(collectionId));
        return "item/list";
    }

    @GetMapping("/update/{id}")
    public String updatePage(Model model, @PathVariable Long id) {
        model.addAttribute("item", service.get(id));
        return "item/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute ItemUpdateDto dto) {
        service.update(dto);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deletePage(Model model, @PathVariable Long id) {
        model.addAttribute("item", service.get(id));
        return "item/delete";
    }

    @GetMapping({"/item/search/{query}", "/search/{query}"})
    public String search(Model model, @PathVariable String query) {
//        model.addAllAttributes(searchService.getItemBasedOnWord(query));
        return "item/search_result";
    }

}
