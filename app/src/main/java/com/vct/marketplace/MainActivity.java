package com.vct.marketplace;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
         {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    private RecyclerView rvCategory;
    private ArrayList<Items> list;

    public String name, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        //        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
       // drawer.addDrawerListener(toggle);
        //toggle.syncState();

        //NavigationView navigationView = findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);

        //View header = navigationView.getHeaderView(0);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        //TextView userEmail = header.findViewById(R.id.userEmail);
        //userEmail.setText(user.getEmail());
        email = user.getEmail();

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(ItemData.getListData());

        showRecyclerGrid();

        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usersRef = mRef.child("Users/" + mAuth.getCurrentUser().getUid());
        usersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Users currentUser = dataSnapshot.getValue(Users.class);
                //NavigationView navigationView = findViewById(R.id.nav_view);
                //View header = navigationView.getHeaderView(0);
                //TextView userName = header.findViewById(R.id.userName);
                //userName.setText(currentUser.getName());
                name = currentUser.getName();
                Toolbar toolbar = findViewById(R.id.toolbar);
                DrawerUtil.getDrawer(MainActivity.this, toolbar, name, email);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onBackPressed() {
       // DrawerLayout drawer = findViewById(R.id.drawer_layout);
       // if (drawer.isDrawerOpen(GravityCompat.START)) {
      //      drawer.closeDrawer(GravityCompat.START);
       // } else {
       //     super.onBackPressed();
       // }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

  //  @SuppressWarnings("StatementWithEmptyBody")
   // @Override
 //   public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
  //      int id = item.getItemId();

  //      if (id == R.id.nav_logout) {
   //         try{
     //           mAuth.signOut();
    //            Toast.makeText(MainActivity.this, "Logout successful", Toast.LENGTH_SHORT).show();
       //         Intent intent = new Intent(MainActivity.this, LoginActivity.class);
       //         startActivity(intent);
       //     } catch (Exception e){
      //          e.printStackTrace();
     //       }
     //   }

    //    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    //    drawer.closeDrawer(GravityCompat.START);
    //    return true;
  //  }

    private void showSelectedItem(Items item){
        Intent intent = new Intent(this, ItemDetailActivity.class);
        String name  = item.getName();
        String img = item.getImg();
        String sizes = item.getSizes();
        String desc = item.getDesc();
        String colors = item.getColors();
        String profile = item.getProfile();
        String seller = item.getSeller();
        String price = item.getPrice();
        String stock = item.getStock();
        intent.putExtra("itemName",name);
        intent.putExtra("itemImg",img);
        intent.putExtra("itemSizes",sizes);
        intent.putExtra("itemDesc",desc);
        intent.putExtra("itemColors",colors);
        intent.putExtra("sellerProfile",profile);
        intent.putExtra("sellerName",seller);
        intent.putExtra("itemPrice",price);
        intent.putExtra("itemStock",stock);
        startActivity(intent);
    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListSellerAdapter listSellerAdapter = new ListSellerAdapter(this);
        listSellerAdapter.setListItems(list);
        rvCategory.setAdapter(listSellerAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedItem(list.get(position));
            }
        });
    }
     private void showRecyclerGrid(){
         rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
         GridItemAdapter gridItemAdapter = new GridItemAdapter(this);
         gridItemAdapter.setListItem(list);
         rvCategory.setAdapter(gridItemAdapter);

         ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
             @Override
             public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                 showSelectedItem(list.get(position));
             }
         });
     }
     private void showRecyclerCardView(){
         rvCategory.setLayoutManager(new LinearLayoutManager(this));
         //CardViewPresidentAdapter cardViewPresidentAdapter = new CardViewPresidentAdapter(this);
         //cardViewPresidentAdapter.setListPresident(list);
        // rvCategory.setAdapter(cardViewPresidentAdapter);
     }
}
