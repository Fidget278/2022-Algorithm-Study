// https://leetcode.com/problems/longest-absolute-file-path/
// leetcode - 388.Longest Absolute File Path
// 작성자 : 김성중

var lengthLongestPath = function (input) {
  console.log("input - " + input);
  const file = input.split("\n");
  console.log("file - " + file);
  const paths = [0];
  const dfs = (path = "", dep = 0) => {
    if (path.includes(".")) {
      paths.push(path.length - 1);
      console.log("dfs.paths - " + paths);
      return;
    }
    const t = "\t".repeat(dep);
    console.log("dfs.t - " + t);

    for (let index = 0; index < file.length; index++) {
      const [current] = file;
      console.log("index - " + index + " dfs.[current] - " + [current]);
      if (!current.includes(t)) return;
      index -= 1;
      const nextPath = `/${file.shift().replace(t, "")}`;
      console.log("index - " + index + " dfs.nextPath - " + nextPath);

      dfs(path + nextPath, dep + 1);
    }
  };

  dfs();
  return Math.max(...paths);
};

console.log(
  lengthLongestPath(
    "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
  )
);
