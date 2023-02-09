export interface PostStore {
  selectedPostId?: number;
  setSelectedPostId: (id: number) => void;
}
