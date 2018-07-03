export class CategoriaPai {
  id: number;
  designacao: string;
}

export class Categoria{
  id: number;
  categoriaPai: CategoriaPai;
  designacao: string;
}

