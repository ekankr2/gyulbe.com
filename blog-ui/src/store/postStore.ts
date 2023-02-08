import create from 'zustand';
import { PostStore } from './types';

export const usePostStore = create<PostStore>((set) => ({
  selectedPostId: undefined,
  setSelectedPostId: (id: number) => {
    set({ selectedPostId: id });
  },
}));
