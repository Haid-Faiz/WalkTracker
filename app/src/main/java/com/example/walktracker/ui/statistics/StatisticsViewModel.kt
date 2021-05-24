package com.example.walktracker.ui.statistics

import com.example.walktracker.repositories.MainRepo

class StatisticsViewModel constructor(
    mainRepo: MainRepo  // We don't need to define recipe of MainRepo in Module, Dagger will
                        // automatically look to make a repo ~ Oh... i only need RunDao & i know how to
                        // create RunDao object (as runDao recipe is define in module). So, don't worry
                        // i can create MainRepo object without knowing its recipe.☻
) {


}