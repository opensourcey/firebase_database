 DatabaseReference mRootDB, mUsersDB, mUserIDDB, mAddDATA;

        // Get firbase Use
        mUser = FirebaseAuth.getInstance().getCurrentUser();

        // Coonnect to database
        mDB = FirebaseDatabase.getInstance();
        mRootDB = mDB.getReference();
        mUsersDB =  mRootDB.child("Users");
        mUserIDDB = mUsersDB.child( mUser.getUid() );
        mAddDATA = mUserIDDB.child("AddMoney");
        mNewPUSH = mAddDATA.push();
        
        
        
        
 //Add To DataBase
                mNewPUSH.child("Reason").setValue(mReasonString);
                mNewPUSH.child("Amount").setValue(mAmountString);
                mNewPUSH.child("Time").setValue(date);
