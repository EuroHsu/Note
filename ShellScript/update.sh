dir=$(ls -l |awk '/^d/ {print $NF}')
for i in $dir
do
  cd $i
  if [ -d ".git" ]; then
    echo $(pwd)
    branchPath=$(cat .git/HEAD)
    branch=${branchPath:16}
    git fetch --all -p
    git pull origin $branch
    echo "============================================================="
  fi
  cd ..
done