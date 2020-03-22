package a1824jj.jp.ac.aiit.sampel_bookshop.viewmodel;

import android.app.Application;

import java.util.List;

import a1824jj.jp.ac.aiit.sampel_bookshop.model.Book;
import a1824jj.jp.ac.aiit.sampel_bookshop.model.Category;
import a1824jj.jp.ac.aiit.sampel_bookshop.model.EBookShopRepository;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MainActivityViewModel extends AndroidViewModel {

    private EBookShopRepository eBookShopRepository;

    private LiveData<List<Category>> allCategories;
    private LiveData<List<Book>> booksOfASelectedCategory;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        eBookShopRepository = new EBookShopRepository(application);
    }

    public LiveData<List<Category>> getAllCategories() {
        allCategories = eBookShopRepository.getCategories();
        return allCategories;
    }

    public LiveData<List<Book>> getBooksOfASelectedCategory(int categoryId) {
        booksOfASelectedCategory = eBookShopRepository.getBooks(categoryId);
        return booksOfASelectedCategory;
    }

    public void addNewBook(Book book){
        eBookShopRepository.insertBook(book);
    }

    public void updateBook(Book book){
        eBookShopRepository.updateBook(book);
    }

    public void deleteBook(Book book){
        eBookShopRepository.deleteBook(book);
    }

}
