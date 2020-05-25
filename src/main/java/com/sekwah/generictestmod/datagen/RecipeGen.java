package com.sekwah.generictestmod.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;

import java.util.function.Consumer;

public class RecipeGen extends RecipeProvider {

    public RecipeGen(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> p_200404_1_) {
        // TODO look at recipebuilders
    }
}
