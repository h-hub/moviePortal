/**
 * Created by bjayamanna on 6/8/2017.
 */
import { Component } from '@angular/core';

import { Movie } from '../movie/movie';

@Component({
  selector: 'app-create-movie',
  templateUrl: '/create-movie.component.html',
  styleUrls: ['/create-movie.component.css']
})
export class CreateMovieComponent {

  model = new Movie('', '', '', '', '', '');

  submitted = false;
  onSubmit() { this.submitted = true; }
}
