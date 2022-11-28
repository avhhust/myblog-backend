import React from "react";
import { useEffect, useState } from "react";
import { Button, FlatList, TouchableOpacity, View } from "react-native";
import Post from "./Post";
import PostService from '../networking/PostService'

export default function PostsView({ navigation, route }) {
  const [isLoading, setLoading] = useState(false);
  const [posts, setPosts] = useState([]);
  const [refreshing, setRefreshing] = useState(false);

  useEffect(() => {
    setLoading(true);
    onRefresh();
  }, []);

  const onRefresh = async () => {
    setRefreshing(true);
    const res = await PostService.getMostPopularPosts();
    setPosts(res);
    setRefreshing(false);
  }

  const renderPost = ({ item }) => (
    <TouchableOpacity>
      <Post briefTitle={item.metaTitle} image={''} title=''/>
    </TouchableOpacity>

  );

  const pressAddPost = () => {
    navigation.navigate("Brief Description");
  }

  return (
    <View>
      <FlatList
        style={{ height: "92%" }}
        data={posts}
        renderItem={renderPost}
        refreshing={refreshing}
        onRefresh={onRefresh}
      />
      <Button title="Create Post" onPress={pressAddPost} />
    </View>
  );
}
