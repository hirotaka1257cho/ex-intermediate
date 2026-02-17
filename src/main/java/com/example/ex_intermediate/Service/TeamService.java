package com.example.ex_intermediate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ex_intermediate.Repository.TeamRepository;
import com.example.ex_intermediate.domain.Team;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TeamService {

    @Autowired
    private TeamRepository repository;

    /**
     * リポジトリのメソッドを利用する
     * @return 結果を返す
     */
    public List<Team> showList(){
        return repository.findAllByOrderByInaugurationAsc();
    }

    /**
     * 引数に入れたidを取得するメソッド
     * @param id idを入れる
     * @return 結果を返す
     */
    public Team showDetail(Integer id){
        return repository.findById(id).orElse(null);
    }
}
