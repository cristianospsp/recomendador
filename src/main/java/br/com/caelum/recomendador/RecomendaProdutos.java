package br.com.caelum.recomendador;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import java.io.IOException;
import java.util.List;

public class RecomendaProdutos {

	public static void main(String[] args) throws IOException, TasteException {

		DataModel produtos = new Recomendador().getModeloProdutos();

		UserSimilarity similarity = new PearsonCorrelationSimilarity(produtos);
		UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, produtos);
		UserBasedRecommender recommender = new GenericUserBasedRecommender(produtos, neighborhood, similarity);


		List<RecommendedItem> recommendations = recommender.recommend(2, 3);
		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}



	}


}
