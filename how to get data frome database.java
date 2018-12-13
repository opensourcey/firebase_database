//LOcal
        DatabaseReference mRootDB, mUsersDB, mUserIDDB, mUseDATA;

        // Get firbase Use
        mUser = FirebaseAuth.getInstance().getCurrentUser();

        // Coonnect to database
        mDB = FirebaseDatabase.getInstance();
        mRootDB = mDB.getReference();
        mUsersDB =  mRootDB.child("Users");
        mUserIDDB = mUsersDB.child( mUser.getUid() );
        mUseDATA = mUserIDDB.child("AddMoney");

        mUseDATAList = findViewById(R.id.listView_addList);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, mData);
        mUseDATAList.setAdapter(arrayAdapter);

        mUseDATA.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {               
                String valu = "\nValue: "+dataSnapshot.child("Amount").getValue().toString()+"\nReason: "+dataSnapshot.child("Reason").getValue().toString()+"\nTime: "+dataSnapshot.child("Time").getValue().toString()+"\n";
                mData.add(valu);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
