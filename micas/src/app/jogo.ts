import {Categoria} from "./categoria";

export class Jogo{
  id: number;
  nome: string;
  link: string;
  //imagem : ??? ;
  descricao: string;
  categorias: Categoria[];
}
