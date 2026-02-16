package com.example.ex_intermediate.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex_intermediate.Service.TeamService;
import com.example.ex_intermediate.domain.Team;

@Controller
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService service;

    /**
     * 発足年を一覧で表示する
     * @param model requestスコープ
     * @return スコープの中身を返す
    */
    @GetMapping("/list")
    public String showList(Model model){
        List<Team> teamList = service.showList();
        model.addAttribute("teamList", teamList);
        return "team/list";
    }

    /**
     * 指定されたidのチーム情報を表示
     * @param id　クエリパラメータを受け取る
     * @param model　requestスコープ
     * @return　取得した情報
     */
    @GetMapping("/detail")
    public String showDetail(@RequestParam("id") Integer id, Model model) {
    Team team = service.showDetail(id);
    model.addAttribute("team", team);
    return "team/detail";
}

}
