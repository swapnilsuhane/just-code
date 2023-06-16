interface MostPopular {
    /**
     * contentId +ve
     * 0 or b
     * @param contentId
     */
    void increasePopularity(Integer contentId);

    /**
     * 0 or below then no need -> -1
     * @return
     */
    Integer mostPopular();
    void decreasePopularity(Integer contentId);
}