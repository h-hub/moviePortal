import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { MovieComponent } from './movie/movie/movie.component';
import { CreateMovieComponent } from './movie/create-movie/create-movie.component';

@NgModule({
  declarations: [
    AppComponent,
    MovieComponent,
    CreateMovieComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
