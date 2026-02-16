package com.example.ex_intermediate.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex_intermediate.domain.Team;

public interface TeamRepository extends JpaRepository<Team, Integer>{

    /**
     * 
     * 発足年ごとに取得するメソッド
     */
    List<Team> findAllByOrderByInaugurationAsc();
}
