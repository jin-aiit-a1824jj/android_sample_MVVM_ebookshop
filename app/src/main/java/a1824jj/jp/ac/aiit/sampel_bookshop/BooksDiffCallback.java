package a1824jj.jp.ac.aiit.sampel_bookshop;

import java.util.ArrayList;

import a1824jj.jp.ac.aiit.sampel_bookshop.model.Book;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;

public class BooksDiffCallback extends DiffUtil.Callback {

    ArrayList<Book> oldBookList;
    ArrayList<Book> newBookList;

    public BooksDiffCallback(ArrayList<Book> oldBookList, ArrayList<Book> newBookList) {
        this.oldBookList = oldBookList;
        this.newBookList = newBookList;
    }

    @Override
    public int getOldListSize() {
        return oldBookList == null ? 0 : oldBookList.size();
    }

    @Override
    public int getNewListSize() {
        return newBookList == null ? 0 : newBookList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldBookList.get(oldItemPosition).getBookId() == newBookList.get(newItemPosition).getBookId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldBookList.get(oldItemPosition).equals(newBookList.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        return super.getChangePayload(oldItemPosition, newItemPosition);
    }
}
