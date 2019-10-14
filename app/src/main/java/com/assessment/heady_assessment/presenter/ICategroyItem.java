package com.assessment.heady_assessment.presenter;

import com.assessment.heady_assessment.data_model.Category;
import com.assessment.heady_assessment.data_model.Ranking;

import java.util.List;

public interface ICategroyItem {
    void OnClickedCategoryItem(Category category, List<Ranking> ranking);
}
