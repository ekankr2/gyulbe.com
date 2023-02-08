import React from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { useDeletePost, useGetPostInfo, useUpdatePost } from '../../../api/hooks/postHooks';
// @ts-ignore
import { ReactComponent as VerticalDots } from '../../../assets/dots-vertical.svg';
import { Group, Menu } from '@mantine/core';
import { Pencil, Trash } from 'tabler-icons-react';
import { usePostStore } from '../../../store/postStore';

const PostDetailPage = () => {
  const navigate = useNavigate();
  const { id } = useParams<{ id: string }>();
  const { data: postInfo } = useGetPostInfo(id);
  const { mutate: deletePost } = useDeletePost();
  const setSelectedPostId = usePostStore((state) => state.setSelectedPostId);

  const handleUpdate = (e: React.MouseEvent) => {
    e.preventDefault();
    if (id) {
      setSelectedPostId(+id);
      return navigate('/post/update');
    }
  };

  const handleDelete = (e: React.MouseEvent) => {
    e.preventDefault();
    if (id) {
      deletePost(id, {
        onSuccess: () => {
          alert('성공!');
          return navigate('/');
        },
      });
    }
  };

  return (
    <>
      {postInfo && (
        <section className="mx-[20px] mt-[40px] md:mx-auto md:max-w-[750px]">
          <article className="border-b-[1px] border-solid border-gray-200 pb-[20px]">
            <img className="h-full max-h-[300px] w-full rounded-xl" src="/sample-img.jpg" alt="main-image" />
            <div className="flex w-full items-end justify-between">
              <div>
                <h1 className="mt-[20px] text-5xl font-bold">{postInfo.title}</h1>
                <p className="mt-[20px] text-sm text-zinc-400">{new Date(postInfo.createdAt).toLocaleDateString()}</p>
              </div>
              <Group position="center">
                <Menu withArrow width={200} shadow="md">
                  <Menu.Target>
                    <span className="cursor-pointer">
                      <VerticalDots width={24} height={24} fill="#a1a1aa" />
                    </span>
                  </Menu.Target>

                  <Menu.Dropdown>
                    <Menu.Item onClick={handleUpdate} icon={<Pencil size={14} />}>
                      Edit Post
                    </Menu.Item>
                    <Menu.Item onClick={handleDelete} color="red" icon={<Trash size={14} />}>
                      Delete Post
                    </Menu.Item>
                  </Menu.Dropdown>
                </Menu>
              </Group>
            </div>
          </article>
          <article className="pt-[40px]">
            <p className="text-gray-600">{postInfo.content}</p>
          </article>
        </section>
      )}
    </>
  );
};

export default PostDetailPage;
