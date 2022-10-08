package com.backend.demoHabr.Comments;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {
}
