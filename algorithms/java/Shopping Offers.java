public class Solution {
    Map<List<Integer>, Integer> amount;
    List<Integer> prices;
    List<List<Integer> > specialOffer;
    int numItems;
    
    private boolean canTakeTheOffer(List<Integer> offer, List<Integer> needs) {
        for(int j = 0;j < numItems;++j) {
            if(offer.get(j) > needs.get(j)) {
                return false;
            }    
        }
        return true;
    }
    
    private int getOffer(List<Integer> needs) {
        if(amount.containsKey(needs)) {
            return amount.get(needs);
        }
        
        int minPrice = 0;
         List<Integer> newNeeds = new ArrayList<>();
        for(int j = 0;j < numItems;++j) {
            minPrice += prices.get(j) * needs.get(j);
            newNeeds.add(needs.get(j));
        }

        for(int i = 0;i < specialOffer.size();++i) {
            List<Integer> offer = specialOffer.get(i);
            if(canTakeTheOffer(offer, needs)) {
                for(int j = 0;j < numItems;++j) {
                    newNeeds.set(j, needs.get(j) - offer.get(j));
                }
                minPrice = Math.min(minPrice, getOffer(newNeeds) + offer.get(numItems));
            }
        }
        amount.put(needs, minPrice);
        return minPrice;
    }
    
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        numItems = price.size();
        if(needs.size() != numItems) {
            throw new IllegalArgumentException();
        }
        
        amount = new HashMap<>();
        specialOffer = special;
        prices = price;
        
        return getOffer(needs);
    }
}