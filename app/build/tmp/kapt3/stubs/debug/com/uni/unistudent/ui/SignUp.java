package com.uni.unistudent.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\u0012\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u000e\u0010$\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u0005H\u0002J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020#H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006,"}, d2 = {"Lcom/uni/unistudent/ui/SignUp;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/uni/unistudent/ui/FragmentSignUpSubData$CollectDataListener;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "binding", "Lcom/uni/unistudent/databinding/ActivitySignUpBinding;", "fireStorageViewModel", "Lcom/uni/unistudent/viewModel/FireStorageViewModel;", "getFireStorageViewModel", "()Lcom/uni/unistudent/viewModel/FireStorageViewModel;", "fireStorageViewModel$delegate", "Lkotlin/Lazy;", "progressPar", "Landroid/widget/ProgressBar;", "userImageUri", "Landroid/net/Uri;", "viewModel", "Lcom/uni/unistudent/viewModel/AuthViewModel;", "getViewModel", "()Lcom/uni/unistudent/viewModel/AuthViewModel;", "viewModel$delegate", "nextFragment", "", "fragment", "Landroidx/fragment/app/Fragment;", "observeSignUp", "observeUploadedImage", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "previousFragment", "showTopSnackBar", "view", "Landroid/view/View;", "message", "signUp", "bundle", "Companion", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class SignUp extends androidx.appcompat.app.AppCompatActivity implements com.uni.unistudent.ui.FragmentSignUpSubData.CollectDataListener {
    private com.uni.unistudent.databinding.ActivitySignUpBinding binding;
    private final kotlin.Lazy viewModel$delegate = null;
    private final kotlin.Lazy fireStorageViewModel$delegate = null;
    private com.google.firebase.auth.FirebaseAuth auth;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String TAG = "SignUp";
    private android.widget.ProgressBar progressPar;
    private android.net.Uri userImageUri;
    @org.jetbrains.annotations.NotNull
    public static final com.uni.unistudent.ui.SignUp.Companion Companion = null;
    public static final int IMAGE_REQUEST_CODE = 100;
    
    public SignUp() {
        super();
    }
    
    private final com.uni.unistudent.viewModel.AuthViewModel getViewModel() {
        return null;
    }
    
    private final com.uni.unistudent.viewModel.FireStorageViewModel getFireStorageViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTAG() {
        return null;
    }
    
    public final void nextFragment(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment fragment) {
    }
    
    public final void previousFragment(@org.jetbrains.annotations.NotNull
    androidx.fragment.app.Fragment fragment) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void observeSignUp() {
    }
    
    private final void observeUploadedImage() {
    }
    
    @java.lang.Override
    public void signUp(@org.jetbrains.annotations.NotNull
    android.os.Bundle bundle) {
    }
    
    private final void showTopSnackBar(android.view.View view, java.lang.String message) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/uni/unistudent/ui/SignUp$Companion;", "", "()V", "IMAGE_REQUEST_CODE", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}