package ghoneim.eservices.animeProject.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ghoneim.eservices.animeProject.model.Anime;

public class AnimeViewModel extends ViewModel {

    private MutableLiveData<Anime> anime = new MutableLiveData<>();

    public void setAnime(Anime anime) {
        this.anime.setValue(anime);
    }

    public LiveData<Anime> getAnime() {
        return anime;
    }
}
