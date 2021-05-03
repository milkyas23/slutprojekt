public class links {
    private int story_id;
    private int target_id;
    private String description;

    public int getStory_id() {

        return story_id;
    }

    public void setStory_id(int story_id) {

        this.story_id = story_id;
    }

    public int getTarget_id() {

        return target_id;
    }

    public void setTarget_id(int target_id) {

        this.target_id = target_id;
    }
    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }


    public links(int story_id, int target_id, String description) {
        this.story_id = story_id;
        this.target_id = target_id;
        this.description = description;
    }

}