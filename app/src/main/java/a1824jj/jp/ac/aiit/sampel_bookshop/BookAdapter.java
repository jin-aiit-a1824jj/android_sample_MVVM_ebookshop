package a1824jj.jp.ac.aiit.sampel_bookshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import a1824jj.jp.ac.aiit.sampel_bookshop.databinding.BookListItemBinding;
import a1824jj.jp.ac.aiit.sampel_bookshop.model.Book;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private onItemClickListener listener;
    private ArrayList<Book> books = new ArrayList<>();

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        BookListItemBinding bookListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.book_list_item, parent, false);
        return new BookViewHolder(bookListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = books.get(position);
        holder.bookListItemBinding.setBook(book);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> newBooks){
        //this.books = books;
        //notifyDataSetChanged();

        final DiffUtil.DiffResult result = DiffUtil.calculateDiff(new BooksDiffCallback(books, newBooks), false);
        books = newBooks;
        result.dispatchUpdatesTo(BookAdapter.this);

    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        private BookListItemBinding bookListItemBinding;
        public BookViewHolder(BookListItemBinding bookListItemBinding){
            super(bookListItemBinding.getRoot());
            this.bookListItemBinding = bookListItemBinding;
            bookListItemBinding.getRoot().setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int clickedPosition = getAdapterPosition();
                    if(listener != null && clickedPosition != RecyclerView.NO_POSITION)
                        listener.onItemClick(books.get(clickedPosition));
                }
            });
        }
    }

    public interface onItemClickListener {
        void onItemClick(Book book);
    }

    public void setListener(onItemClickListener listener){
        this.listener = listener;
    }

}

